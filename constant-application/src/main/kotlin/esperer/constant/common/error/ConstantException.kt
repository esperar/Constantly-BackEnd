package esperer.constant.common.error

abstract class ConstantException(
    val errorProperty: ErrorProperty
) : RuntimeException() {

    override fun fillInStackTrace() = this
}