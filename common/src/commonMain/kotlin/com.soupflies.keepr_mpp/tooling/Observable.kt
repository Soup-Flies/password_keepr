package com.soupflies.keepr_mpp.tooling

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// TODO: Have setter reference internal setter here so this can be mutable but top declaration is not.
class Observable<T>(initial: T): ReadWriteProperty<Any?, T> {
    private var observers: MutableMap<Int, (old: T, new: T) -> Unit > = mutableMapOf()
    var value: T by Delegates.observable(initialValue = initial) { prop, old, new ->
        observers.forEach { it.value.invoke(old, new) }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T = value
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) { this.value = value }

    fun addObserver(key: Int, onChange: (old: T, new: T) -> Unit ) {

        try {
            val prevObserver = observers[key]
            if (prevObserver != null) Logger.w("Common-Observable", "Avoid overwriting observers before unsetting them: $key")
            observers[key] = onChange
        } catch (e: Exception) {
                Logger.e("Observable", "Observable Unhandled Exception:", e)
        }
    }
    fun removeObserver(key: Int) = observers.remove(key)
    fun removeAllObservers() = observers.clear()
}