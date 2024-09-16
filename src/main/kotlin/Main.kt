import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.File
import java.io.InputStream

fun main(){
    /*
    var fin = FileInputStream("C:\\Users\\jimoonsung2\\IdeaProjects\\MakeQuestion\\src\\main\\data.txt")
    var fout = FileOutputStream("./dataout.txt")

    var data = fin.read()
    println("바이트 하나 읽기 : $data , ${data.toChar()}")
    println("데이터 자료형 확인 : ${data.javaClass.kotlin}")

    while (data != -1) {
        fout.write(data)
        data = fin.read()
    }

    fin.close()
    fout.close()

    val fin1 = FileInputStream("./dataout.txt")
    var data1 = fin1.read()
    while (data1 != -1) {
        print(data1.toChar())
        data1 = fin1.read()
    }

    fin1.close()
*/
    val inputStream: InputStream = File("C:\\\\Users\\\\jimoonsung2\\\\IdeaProjects\\\\MakeQuestion\\\\src\\\\main\\\\data.txt").inputStream()
    //val inputString = inputStream.bufferedReader().use{it.readText()}
    //println(inputString)

    //InputText_to_db(inputStream)
    //println(CuttingStreamToQuestion(inputStream))


    //println(ChangelineToSpace(inputString))
    println(MakeQuestionArrayList(inputStream))
    inputStream.close()
}

