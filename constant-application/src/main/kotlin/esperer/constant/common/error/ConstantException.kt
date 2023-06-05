package esperer.constant.common.error

abstract class ConstantException(
    private val errorProperty: ErrorProperty
) : RuntimeException() {

    override fun fillInStackTrace() = this
}