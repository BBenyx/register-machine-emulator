package parsingCreators.operandCreators
import operands.ImmediateValue
import operands.Operand
import parsingCreators.OperandCreator

class ImmediateCreator: OperandCreator {

    override fun compatible(value: String?) = value == null || value[0] == '='

    override fun create(address: String?): Operand {
        require(address == null || address[0] == '=') {"ERROR! Immediate operand creation called for a non-immediate address: $address"}

        if (address == null) {
            return ImmediateValue(address)
        } else {
            val trimmedAddress: Int = address.trim('=').toInt()
            return ImmediateValue(trimmedAddress)
        }
    }
}