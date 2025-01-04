package top.niunaijun.blackbox.entity.am;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

import top.niunaijun.blackbox.reflect.android.content.BRBroadcastReceiver;
import top.niunaijun.blackbox.utils.compat.BuildCompat;

/**
 * Created by BlackBox on 2022/2/28.
 */
public class PendingResultData implements Parcelable {
    public int mType;
    public boolean mOrderedHint;
    public boolean mInitialStickyHint;
    public IBinder mToken;
    public int mSendingUser;
    public int mFlags;
    public int mResultCode;
    public String mResultData;
    public Bundle mResultExtras;
    public boolean mAbortBroadcast;
    public boolean mFinished;
    public String mBToken;

    public PendingResultData(BroadcastReceiver.PendingResult pendingResult) {
        mBToken = UUID.randomUUID().toString();
        if (BuildCompat.isM()) {
            this.mType = BRBroadcastReceiver.PendingResultM.mType.get(pendingResult);
            this.mOrderedHint = BRBroadcastReceiver.PendingResultM.mOrderedHint.get(pendingResult);
            this.mInitialStickyHint = BRBroadcastReceiver.PendingResultM.mInitialStickyHint.get(pendingResult);
            this.mToken = BRBroadcastReceiver.PendingResultM.mToken.get(pendingResult);
            this.mSendingUser = BRBroadcastReceiver.PendingResultM.mSendingUser.get(pendingResult);
            this.mFlags = BRBroadcastReceiver.PendingResultM.mFlags.get(pendingResult);
            this.mResultData = BRBroadcastReceiver.PendingResultM.mResultData.get(pendingResult);
            this.mResultExtras = BRBroadcastReceiver.PendingResultM.mResultExtras.get(pendingResult);
            this.mAbortBroadcast = BRBroadcastReceiver.PendingResultM.mAbortBroadcast.get(pendingResult);
            this.mFinished = BRBroadcastReceiver.PendingResultM.mFinished.get(pendingResult);
        } else {
            this.mType = BRBroadcastReceiver.PendingResult.mType.get(pendingResult);
            this.mOrderedHint = BRBroadcastReceiver.PendingResult.mOrderedHint.get(pendingResult);
            this.mInitialStickyHint = BRBroadcastReceiver.PendingResult.mInitialStickyHint.get(pendingResult);
            this.mToken = BRBroadcastReceiver.PendingResult.mToken.get(pendingResult);
            this.mSendingUser = BRBroadcastReceiver.PendingResult.mSendingUser.get(pendingResult);
            this.mResultData = BRBroadcastReceiver.PendingResult.mResultData.get(pendingResult);
            this.mResultExtras = BRBroadcastReceiver.PendingResult.mResultExtras.get(pendingResult);
            this.mAbortBroadcast = BRBroadcastReceiver.PendingResult.mAbortBroadcast.get(pendingResult);
            this.mFinished = BRBroadcastReceiver.PendingResult.mFinished.get(pendingResult);
        }
    }

    public BroadcastReceiver.PendingResult build() {
        if (BuildCompat.isM()) {
            return BRBroadcastReceiver.PendingResultM._new.newInstance(mResultCode, mResultData, mResultExtras, mType, mOrderedHint, mInitialStickyHint, mToken, mSendingUser, mFlags);
        }
        return BRBroadcastReceiver.PendingResult._new.newInstance(mResultCode, mResultData, mResultExtras, mType, mOrderedHint, mInitialStickyHint, mToken, mSendingUser);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mType);
        dest.writeByte(this.mOrderedHint ? (byte) 1 : (byte) 0);
        dest.writeByte(this.mInitialStickyHint ? (byte) 1 : (byte) 0);
        dest.writeStrongBinder(this.mToken);
        dest.writeInt(this.mSendingUser);
        dest.writeInt(this.mFlags);
        dest.writeInt(this.mResultCode);
        dest.writeString(this.mResultData);
        dest.writeBundle(this.mResultExtras);
        dest.writeByte(this.mAbortBroadcast ? (byte) 1 : (byte) 0);
        dest.writeByte(this.mFinished ? (byte) 1 : (byte) 0);
        dest.writeString(this.mBToken);
    }

    public void readFromParcel(Parcel source) {
        this.mType = source.readInt();
        this.mOrderedHint = source.readByte() != 0;
        this.mInitialStickyHint = source.readByte() != 0;
        this.mToken = source.readStrongBinder();
        this.mSendingUser = source.readInt();
        this.mFlags = source.readInt();
        this.mResultCode = source.readInt();
        this.mResultData = source.readString();
        this.mResultExtras = source.readBundle();
        this.mAbortBroadcast = source.readByte() != 0;
        this.mFinished = source.readByte() != 0;
        this.mBToken = source.readString();
    }

    protected PendingResultData(Parcel in) {
        this.mType = in.readInt();
        this.mOrderedHint = in.readByte() != 0;
        this.mInitialStickyHint = in.readByte() != 0;
        this.mToken = in.readStrongBinder();
        this.mSendingUser = in.readInt();
        this.mFlags = in.readInt();
        this.mResultCode = in.readInt();
        this.mResultData = in.readString();
        this.mResultExtras = in.readBundle();
        this.mAbortBroadcast = in.readByte() != 0;
        this.mFinished = in.readByte() != 0;
        this.mBToken = in.readString();
    }

    public static final Parcelable.Creator<PendingResultData> CREATOR = new Parcelable.Creator<PendingResultData>() {
        @Override
        public PendingResultData createFromParcel(Parcel source) {
            return new PendingResultData(source);
        }

        @Override
        public PendingResultData[] newArray(int size) {
            return new PendingResultData[size];
        }
    };

    @Override
    public String toString() {
        return "PendingResultData{" +
                "mType=" + mType +
                ", mOrderedHint=" + mOrderedHint +
                ", mInitialStickyHint=" + mInitialStickyHint +
                ", mToken=" + mToken +
                ", mSendingUser=" + mSendingUser +
                ", mFlags=" + mFlags +
                ", mResultCode=" + mResultCode +
                ", mResultData='" + mResultData + '\'' +
                ", mResultExtras=" + mResultExtras +
                ", mAbortBroadcast=" + mAbortBroadcast +
                ", mFinished=" + mFinished +
                '}';
    }
}
