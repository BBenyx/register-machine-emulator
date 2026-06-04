package factorySupport
import java.io.File

class FileReader {

    fun readFile(path: String): List<String> {
        val list: ArrayList<String> = arrayListOf()
        File(path).forEachLine { list.add(removeComment(it))}
        return list
    }

    private fun removeComment(line: String): String {
        return line.split("//")[0].trim()
    }

}