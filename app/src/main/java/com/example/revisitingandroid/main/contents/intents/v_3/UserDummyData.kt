package com.example.revisitingandroid.main.contents.intents.v_3

import android.os.Parcel
import android.os.Parcelable

data class UserDummyData(
    val name: String?,
    val age: Int,
    val hobby: String?

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeString(hobby)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserDummyData> {
        override fun createFromParcel(parcel: Parcel): UserDummyData {
            return UserDummyData(parcel)
        }

        override fun newArray(size: Int): Array<UserDummyData?> {
            return arrayOfNulls(size)
        }
    }
}
