package factories

interface Factory <T> {
    fun create(): T
}