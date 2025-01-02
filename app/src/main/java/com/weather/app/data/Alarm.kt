data class Alarm(
    val id: Int = 0,
    val timeInMillis: Long,
    val label: String = "",
    val isEnabled: Boolean = true,
    val repeatDays: List<Int> = emptyList() // 0 = Sunday, 1 = Monday, etc.
) 