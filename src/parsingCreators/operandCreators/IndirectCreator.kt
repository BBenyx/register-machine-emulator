package parsingCreators.operandCreators
import operands.IndirectAddress
import operands.Operand
import parsingCreators.OperandCreator

class IndirectCreator: OperandCreator {

    override fun compatible(value: String?) = value == null || value[0] == '*'

    override fun create(address: String?): Operand {
        require(address != null && address[0] == '*') {"ERROR! Immediate operand creation called for a non-immediate address: $address"}

        val trimmedAddress = address.trim('*').toUInt()
        return IndirectAddress(trimmedAddress)
    }
}