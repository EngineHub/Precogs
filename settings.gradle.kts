rootProject.name = "precogs"

listOf("bukkit", "core", "sponge").forEach {
    include("precogs-$it")
}
