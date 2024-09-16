import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.File
import java.io.InputStream

fun main(){

    val inputStream: InputStream = File("C:\\\\Users\\\\jimoonsung2\\\\IdeaProjects\\\\MakeQuestion\\\\src\\\\main\\\\data.txt").inputStream()

    InputText_to_db(inputStream)

   // println(MakeQuestionArrayList(inputStream))
    inputStream.close()
}

