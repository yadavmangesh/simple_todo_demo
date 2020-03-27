package com.example.demomangesh

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(

        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,

        @ColumnInfo(name = "name")
        var name: String? = null,

        @ColumnInfo(name = "description")
        var description: String? = null,

        @ColumnInfo(name = "number")
        var number: String? = null
):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(p0: Parcel?, p1: Int) {
                p0?.writeInt(id)
                p0?.writeString(name)
                p0?.writeString(description)
                p0?.writeString(number)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Todo> {
                override fun createFromParcel(parcel: Parcel): Todo {
                        return Todo(parcel)
                }

                override fun newArray(size: Int): Array<Todo?> {
                        return arrayOfNulls(size)
                }
        }
}

