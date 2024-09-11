import com.sun.org.apache.xpath.internal.functions.FuncFalse
import java.awt.Choice
import java.io.InputStream
import java.io.BufferedReader
import java.io.EOFException
import javax.security.auth.Subject

/*
    예시)
    1. 정보보안 용어에 대한 설명으로 가장 적절한 것은?
        ① 위협은 자산에 대한 위협원의 공격 행동이다.
        ② 취약점은 위협이 약점을 이용하여 해를 끼치는 순간이나 시점이다.
        ③ 위험은 자산이 가지고 있는 속성이거나 보안 대책의 미비점이다.
        ④ 노출은 자산에 악영향을 미치는 결과를 가져올 가능성이다.


33. 다음은「개인정보보호법」제2조(정의)에 대한내용이다.
빈칸 ㉠, ㉡에 해당하는 가장 적절한 것은?
1. “개인정보”란 살아 있는 개인에 관한 정보로서 다음각목의 어느 하나에 해당하는 정보를 말한다.
가. ( ㉠ ), 주민등록번호 및 ( ㉡ ) 등을 통하여개인을알아볼 수 있는 정보
나. 해당 정보만으로는 특정 개인을 알아볼 수없더라도다른 정보와 쉽게 ( ㉢ )하여 알아볼 수 있는 정보
① ㉠ 성명 ㉡ 전화번호 ㉢ 연계
② ㉠ 성별 ㉡ 전화번호 ㉢ 연계
③ ㉠ 성명 ㉡ 영상 ㉢ 결합
④ ㉠ 성별 ㉡ 영상 ㉢ 연동
 */

class Question(subject: String, stringStream: String) {

    val stringStream = stringStream
    val SubjectOfQuestion = subject
    var QuestionContent = ""
    var QuestionContentBoolean = false
    var Passage = ""
    var PassageBoolean = false
    var Choice1 = ""
    var Choice1Boolean = false
    var Choice2 = ""
    var Choice2Boolean = false
    var Choice3 = ""
    var Choice3Boolean = false
    var Choice4 = ""
    var Choice4Boolean = false
    var QuestionLength = 0

    fun QuestionMain() {

        for (char in stringStream.toCharArray()) {
            QuestionLength++
            if (QuestionContentBoolean == false) {
                if (char == '?') {
                    QuestionContentBoolean = true
                }
                QuestionContent.plus(char)
            } else if (PassageBoolean == false) {
                if (char == '①') {
                    PassageBoolean = true
                    continue
                }
                Passage.plus(char)
            } else if (Choice1Boolean == false) {
                if (char == '②') {
                    Choice1Boolean == true
                    continue
                }
                Choice1.plus(char)
            } else if (Choice2Boolean == false) {
                if (char == '③') {
                    Choice2Boolean == true
                    continue
                }
                Choice2.plus(char)
            } else if (Choice3Boolean == false) {
                if (char == '④') {
                    Choice3Boolean == true
                    continue
                }
                Choice3.plus(char)
            } else if (Choice4Boolean == false) { //특수케이스
                if (char == '②') {
                    Choice4Boolean == true
                    continue
                }
                Choice4.plus(char)
            }

        }
    }

    fun isDigitBetweenOneAndNine(c: Char): Boolean {
        return c in '1'..'9'
    }

    fun UnusaulChoiceDiscriminator(inputString: String): Array<Int> { // return 리스트의 0번째 값 = 0 이면 정상 / 1 이면 특수케이스 / -1이면 비정상 케이스
        var Choice = arrayOf(0, 0, 0, 0, 0)


        for (char in inputString.toCharArray()) {
            when (char) {
                '①' -> Choice[1]++
                '②' -> Choice[2]++
                '③' -> Choice[3]++
                '④' -> Choice[4]++
            }
        }
        if (Choice[1] == 1 && Choice[2] == 1 && Choice[3] == 1 && Choice[4] == 1) {
            return Choice
        } else if (Choice[1] > 1 && Choice[2] > 1 && Choice[3] > 1 && Choice[4] > 1) {
            Choice[0] = 1
            return Choice
        } else {
            println("전형적인 문제 형식이 아닐 가능성이 있습니다. 전형적인 문제형식으로 수정해주세요")
            Choice[0] = -1
            return Choice
        }


    }


    //문제의 처음부터 끝까지를 체크하는 함수가 필요함!!!!







}

fun InputText_to_db(inputStream: InputStream) {
    val inputString = inputStream.bufferedReader().use { it.readLines() }
    var inputOneSentencs: String
    var questionNum: Int // 문제 개수를 세는 배열

    val questionTextList = ArrayList<String>() // 문제 본문을 저장하는 배열
    val answerList = ArrayList<ArrayList<String>>() // 답을 저장하는 이차원 배열

    val data1 = ArrayList<String>()



    var checkStartPoint: Boolean
    var checkEndPoint: Boolean
    questionNum = 1
    var inputCharArray: CharArray
    var indexList = 0
    var index = 0

    checkStartPoint = true
    checkEndPoint = false
    var middleQuestion = false


    while (index <= inputString.lastIndex) {
        inputCharArray = inputString[index].toCharArray()
        for (char in inputCharArray) {
            println(char)
            if (isDigitBetweenOneAndNine(char)) {
                if (checkStartPoint == true && checkEndPoint == true) { // 본문 중 숫자
                    continue
                } else if (checkStartPoint == true && checkEndPoint == false) { // 문제 중간구성번호
                    continue
                } else if (checkStartPoint == false && checkEndPoint == false) { // 문제 시작번호
                    checkStartPoint = true
                } else if (checkStartPoint == false && checkEndPoint == true) {

                }


            } else if (char == '.') {
                if (checkStartPoint == true && checkEndPoint == false) { // 문제 번호 끝 점
                    checkEndPoint == true
                } else if (checkStartPoint == true && checkEndPoint == true) { // 문제 중 '.'
                    continue
                }
            } else if (char == '?') {
                if (checkStartPoint == true && checkEndPoint == true) { // 문제 본문 끝 '?'
                    checkStartPoint = false
                    checkEndPoint = false
                    middleQuestion = true
                } else {
                    continue
                }
                questionTextList[questionNum].plus(char)
            } else {
                if (checkStartPoint == true && checkEndPoint == false) { // 문제 본문
                    if (char == '①') {

                    } else if (char == '②') {

                    } else if (char == '③') {

                    } else if (char == '④') {

                    }
                    questionTextList[questionNum].plus(char)
                }
            }

        }
        index++
    }

    while (index <= inputString.lastIndex) {
        inputCharArray = inputString[index].toCharArray()
        for (char in inputCharArray) {
            println(char)
        }
    }

    println("/")
    println("①")
    println("②")
    println("③")
    println("④")

    println(inputString)
}
    fun isDigitBetweenOneAndNine(c: Char): Boolean {
        return c in '1'..'9'
    }
fun CuttingStreamToQuestion(): String{

}
