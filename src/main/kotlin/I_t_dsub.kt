
/*

class I_t_dsub {



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



fun CuttingStreamToQuestion(inputStream: InputStream): ArrayList<String>{

    var inputString = inputStream.bufferedReader().use { it.readText() }
    var QuestionNum = 0
    var startpoint = false
    var startcheck = false
    var endpoint = false
    var endcheck = false
    val outputString = ArrayList<String>()

    inputString = ChangelineToSpace(inputString)

    for (char in inputString){
        if (startpoint == true && endcheck == true){ //  문제의 시작 ex) 1.
            if (isDigitBetweenOneAndNine(char)){
                outputString[QuestionNum].plus(char)
            }
            else if (char == '.'){  // 문제 시작 번호 ex) 123.
                outputString[QuestionNum].plus(char)
                startcheck = true
                startpoint = false
            }
            else if (char == ' '){
                outputString[QuestionNum].plus(char)
            }
            else{
                outputString[QuestionNum].plus(char)
                startpoint = false
            }
        }
        else if (startpoint == false && startcheck == true ) {   // 문제 본문
            if (endpoint == true && char == '.') {  // 문제의 끝이자 다음 문제의 시작  ex) 이다. 2.
                outputString[QuestionNum].plus(char)
                QuestionNum++
                endcheck = true
            }
            else if (endpoint == true && isDigitBetweenOneAndNine(char)){
                outputString[QuestionNum].plus(char)
            }
            else if (endpoint == true && char == ' '){
                outputString[QuestionNum].plus(char)
            }
            else if (isDigitBetweenOneAndNine(char)){
                outputString[QuestionNum].plus(char)
                endpoint = true
            }
            else{
                outputString[QuestionNum].plus(char)
                endpoint = false
            }

        }
        else if(startpoint == true && endcheck == false){

        }
        else{
            if (isDigitBetweenOneAndNine(char) == true){
                outputString[QuestionNum].plus(char)
                startpoint = true
            }
            else{
                outputString[QuestionNum].plus(char)
            }
        }

    }

    return outputString
}
*/

/*fun QuestionMain() {

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

 */
