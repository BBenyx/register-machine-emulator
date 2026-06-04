package parsingCreators.commandCreators
import commands.Command
import commands.Mult
import operands.Operand
import parsingCreators.CommandCreator

class MultCreator(val memory: ArrayList<Int>): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "MULT"
    }

    override fun create(address: Operand?): Command {
        require(address != null) {"ERROR! Mult command cannot be created with a null address: $address"}

        return Mult(address, memory)
    }
}