package top.niunaijun.blackbox.utils.compat;

import java.lang.reflect.Method;
import java.util.List;

import top.niunaijun.blackbox.reflect.android.content.pm.BRParceledListSlice;

public class ParceledListSliceCompat {
	public static Object create(List<?> list) {
		Object slice = BRParceledListSlice._new1.newInstance(list);
		if (slice != null) {
			return slice;
		} else {
			slice = BRParceledListSlice._new0.newInstance();
		}

		for (Object item : list) {
			BRParceledListSlice.append.call(slice, item);
		}
		BRParceledListSlice.setLastSlice.call(slice, true);
		return slice;
	}
}
