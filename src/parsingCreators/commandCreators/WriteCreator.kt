package parsingCreators.commandCreators
import commands.Command
import commands.Write
import operands.Operand
import parsingCreators.CommandCreator

class WriteCreator(val memory: ArrayList<Int>): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "WRITE"
    }

    override fun create(address: Operand?): Command {
        require(address != null) {"ERROR! Write command cannot be created with a null address: $address"}

        return Write(address, memory)
    }
}