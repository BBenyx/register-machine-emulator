package factorySupport

class InputHandler {
    fun getNonBlankInput(): String {
        print("Enter the machine input: ")
        var input = readln().trim()

        while (input.isEmpty()) {
            print("Enter a non blank machine input: ")
            input = readln().trim()
        }

        return input
    }
}