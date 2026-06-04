package parsingCreators.commandCreators
import commands.Command
import commands.Read
import operands.AddressOperand
import operands.Operand
import parsingCreators.CommandCreator
import registerDataHolders.InputTape

class ReadCreator(val memory: ArrayList<Int>, val inputTape: InputTape): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "READ"
    }

    override fun create(address: Operand?): Command {
        require(address != null) {"ERROR! Read command cannot be created with a null address: $address"}
        require(address is AddressOperand) {"ERROR! Read command cannot be created with an immediate address: $address"}

        return Read(address, inputTape, memory)
    }
}