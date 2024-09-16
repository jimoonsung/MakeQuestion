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

class Question(_subject: String, _questionString: String) {

    val subject = _subject
    val questionString = _questionString
    var QuestionContent = ""
    var Choice1 = ""
    var Choice2 = ""
    var Choice3 = ""
    var Choice4 = ""



    init {
        val QuestionIsUsuaulOrUnusuaul = UnusaulChoiceDiscriminator(questionString)

        when(QuestionIsUsuaulOrUnusuaul[0]){
            0 -> ByUsaul(questionString)
            1 -> ByUnusaual(questionString, QuestionIsUsuaulOrUnusuaul[1], QuestionIsUsuaulOrUnusuaul[2], QuestionIsUsuaulOrUnusuaul[3], QuestionIsUsuaulOrUnusuaul[4])
            -1 -> println("오류입니다.")
        }
    }

    fun ByUsaul(input:String) {
        val compo_buffer = input.split(Regex("①|②|③|④"))

        QuestionContent = compo_buffer[0]
        Choice1 = compo_buffer[1]
        Choice2 = compo_buffer[2]
        Choice3 = compo_buffer[3]
        Choice4 = compo_buffer[4]
    }
    fun ByUnusaual(input: String, num1: Int, num2: Int, num3: Int, num4: Int){

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
        if (Choice[1] == 1 && Choice[2] == 1 && Choice[3] == 1 && Choice[4] == 1) { //Choice[0]이 0이면 일반적 문제
            return Choice
        } else if (Choice[1] > 1 && Choice[2] > 1 && Choice[3] > 1 && Choice[4] > 1) {//Choice[0]이 1이면 특별한 형식의 문제
            Choice[0] = 1
            return Choice
        } else {
            println("전형적인 문제 형식이 아닐 가능성이 있습니다. 전형적인 문제형식으로 수정해주세요") // 오류
            Choice[0] = -1
            return Choice
        }


    }



}

fun InputText_to_db(inputStream: InputStream) {
    val inputString = inputStream.bufferedReader().use { it.readLines() }
    var inputOneSentencs: String
    var questionNum: Int // 문제 개수를 세는 배열

    val questionTextList = ArrayList<String>() // 문제 본문을 저장하는 배열
    val answerList = ArrayList<ArrayList<String>>() // 답을 저장하는 이차원 배열

    val data1 = ArrayList<String>()




}
fun isDigitBetweenOneAndNine(c: Char): Boolean { // 숫자인지 확인하는 함수
    return c in '1'..'9'
}

fun ChangelineToSpace(inputString:String): String{ // 줄바꿈을 공백으로 바꾸는 함수
    return  inputString.replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")
}
fun ProcessingCompleteStringList(inputString: List<String>): ArrayList<String>{
    var outputString = ArrayList<String>()
    var producingString = ArrayList(inputString)
    var index = 0

    for (component in producingString){
        var choice1_check = false
        var choice2_check = false
        var choice3_check = false
        var choice4_check = false
        
        component.trimIndent()

        for (char in component){
            if (char == '①') {
                choice1_check = true
            }
            else if (char == '②'){
                choice2_check = true
            }
            else if (char == '③'){
                choice3_check = true
            }
            else if (char == '④'){
                choice4_check = true
            }
        }
        
        if (choice1_check && choice2_check && choice3_check && choice4_check){
            outputString.add(component)
        }
        else{
            producingString[index + 1] = component + producingString[index + 1]
        }

        index++
    }

    return outputString
}
fun SplitStringbyNum(inputString: String): List<String>{
    val outputstring = ChangelineToSpace(inputString)
    return outputstring.split(Regex("\\d+\\."))
}

fun MakeQuestionArrayList(inputStream: InputStream): ArrayList<String>{
    val inputString = inputStream.bufferedReader().use{it.readText()}
    return ProcessingCompleteStringList(SplitStringbyNum(inputString))
}
