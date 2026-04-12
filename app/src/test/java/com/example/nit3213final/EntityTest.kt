package com.example.nit3213final
import org.junit.Test
import org.junit.Assert.assertEquals
class EntityTest {

    @Test
    fun testEntityData() {

        val entity = Entity(
            name = "Test Item",
            type = "Test Type",
            description = "Test Description"
        )

        assertEquals("Test Item", entity.name)
        assertEquals("Test Type", entity.type)
        assertEquals("Test Description", entity.description)
    }
    @Test
    fun testEntityListSize() {
        val list = listOf(
            Entity("A", "T", "D"),
            Entity("B", "T", "D")
        )

        assertEquals(2, list.size)
    }
}