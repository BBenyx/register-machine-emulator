package factorySupport
import parsingCreators.CommandCreator
import parsingCreators.OperandCreator
import parsingCreators.commandCreators.AddCreator
import parsingCreators.commandCreators.DivCreator
import parsingCreators.commandCreators.HaltCreator
import parsingCreators.commandCreators.JgtzCreator
import parsingCreators.commandCreators.JumpCreator
import parsingCreators.commandCreators.JzeroCreator
import parsingCreators.commandCreators.LoadCreator
import parsingCreators.commandCreators.MultCreator
import parsingCreators.commandCreators.ReadCreator
import parsingCreators.commandCreators.StoreCreator
import parsingCreators.commandCreators.SubCreator
import parsingCreators.commandCreators.WriteCreator
import parsingCreators.operandCreators.DirectCreator
import parsingCreators.operandCreators.ImmediateCreator
import parsingCreators.operandCreators.IndirectCreator
import registerDataHolders.InputTape
import registerDataHolders.ProgramCounter

class ParserCreatorInit {

    fun getOperandCreators(): List<OperandCreator> {
        return arrayListOf(
            DirectCreator(),
            ImmediateCreator(),
            IndirectCreator(),
        )
    }

    fun getCommandCreators(
        memory: ArrayList<Int>,
        inputTape: InputTape,
        programCounter: ProgramCounter
    ): List<CommandCreator> {
        return arrayListOf(
            LoadCreator(memory),
            StoreCreator(memory),
            AddCreator(memory),
            SubCreator(memory),
            DivCreator(memory),
            MultCreator(memory),
            ReadCreator(memory, inputTape),
            WriteCreator(memory),
            JumpCreator(memory, programCounter),
            JgtzCreator(memory, programCounter),
            JzeroCreator(memory, programCounter),
            HaltCreator(programCounter),
        )
    }
}