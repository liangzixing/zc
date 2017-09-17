package com.zc.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListUtil {

	/**
	 * Tells whether or not the given <tt>list</tt> is null or empty.
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isBlank(List<?> list) {
		if (list == null || list.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isBlank(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	public static boolean isNotBlank(Collection<?> collection) {
		return !isBlank(collection);
	}

	/**
	 * Tells whether or not the given <tt>list</tt> at least contains one element.
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isNotBlank(List<?> list) {
		return (!isBlank(list));
	}
	
	/**
	 * Returns the first element of the given list. If the <tt>list</tt> is blank,
	 * return null.
	 * 
	 * @param list
	 * @return
	 */
	public static <T> T first(List<T> list) {
		if (isBlank(list)) {
			return null;
		}
        return list.get(0);
    }
	
	/**
	 * ·µ»ØIdµÄList
	 * @param list
	 * @return
	 */
	public static <T> List<Long> getIds(List<T> list, String methodName) {
		if (isBlank(list)) {
			return null;
		}
		List<Long> ids = new ArrayList<Long>();
		try {
			for (T t : list) {
				Method method = t.getClass().getMethod(methodName);
				Long id = (Long) method.invoke(t);
				ids.add(id);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return ids.size() > 0 ? ids : null;
	}

	public static <T> ArrayList<T> newArrayList(){
		return new ArrayList<T>();
	}

	public static <T> ArrayList<T> newArrayList(int size){
		return new ArrayList<T>(size > 0 ? size : 10);
	}

	public static <T> ArrayList<T> newArrayList(Collection<T> collection){
		ArrayList<T> result = newArrayList(collection.size());
		result.addAll(collection);
		return result;
	}

	public static int size(List<?> list){
		return isBlank(list) ? 0 : list.size();
	}

	public static List<String> toStringList(List<?> list) {
		return skipNullConvert(list, o -> o.toString());
	}

	public static List<Long> toLongList(List<?> list) {
		return skipNullConvert(list, o -> Long.valueOf(o.toString()));
	}

	public static <K, O> Map<K, O> toMap(List<O> list, Function<O, K> keyConverter) {

		if (isBlank(list)) {
            return Collections.emptyMap();
        }

		Map<K, O> map = new HashMap<K, O>();

		list.forEach(o -> map.put(keyConverter.apply(o), o));

		return map;
	}

	public static <K, O> Map<K, List<O>> splitByKey(List<O> list, Function<O, K> keyConverter) {

		if (isBlank(list)) {
            return Collections.emptyMap();
        }

		Map<K, List<O>> map = new HashMap<>();

		list.forEach(l -> map.computeIfAbsent(keyConverter.apply(l), k -> new ArrayList<>()).add(l));

		return map;
	}

	public static <F, O> List<F> collect(List<O> list, Function<O, F> collector) {
		return convert(list, collector);
	}

	public static <F, O> List<F> collectWithOutRepeat(List<O> list, Function<O, F> collector) {
		return new ArrayList<F>(new HashSet<F>(collect(list, collector)));
	}

	public static <T, O> List<T> convert(List<O> list, Function<O, T> converter) {
		if (isBlank(list)) {
            return Collections.emptyList();
        }
		return list.stream().map(converter).collect(Collectors.toList());
	}

	public static <T, O> List<T> skipNullConvert(List<O> list, Function<O, T> converter) {
		if (isBlank(list)) {
            return Collections.emptyList();
        }
		return list.stream().filter(o -> o != null).map(converter).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("12132", "1243547", "1246767", "465762323");

		System.out.println(Arrays.toString(toLongList(list).toArray()));

		List<Double> list2 = Arrays.asList(1.12D, 2D, 3D, 5D, 6D, 7D, 9D, 0D);

		System.out.println(Arrays.toString(toStringList(list2).toArray()));

		List<TestModel> container = new ArrayList<>(10);

		for (int i = 0; i < 10; i++) {
			container.add(TestModel.randomCreate());
		}

		container.forEach(o -> System.out.println(o.toString()));

		System.out.println(" =================== ");

		List<Long> filed2s = convert(container, o -> o.getField2());

		filed2s.forEach(o -> System.out.println(o.toString()));

		System.out.println(" =================== ");

		Map<Integer, TestModel> map = toMap(container, o -> o.getField3());

		map.forEach((k, v) -> System.out.println(k + ":" + v.toString()));

		System.out.println(" =================== ");

		Map<Integer, List<TestModel>> splitMap = splitByKey(container, o -> o.getField3() % 2);

		splitMap.forEach((k, v) -> System.out.println(k + ":" + v.size()));
	}

	static class TestModel {
		private String field1;
		private Long field2;
		private Integer field3;

		public static TestModel randomCreate() {
			TestModel testModel = new TestModel();

			testModel.setField1("testModel");
			testModel.setField2(new Random().nextLong());
			testModel.setField3(new Random().nextInt(10));

			return testModel;
		}

		public String getField1() {
			return field1;
		}

		public void setField1(String field1) {
			this.field1 = field1;
		}

		public Long getField2() {
			return field2;
		}

		public void setField2(Long field2) {
			this.field2 = field2;
		}

		public Integer getField3() {
			return field3;
		}

		public void setField3(Integer field3) {
			this.field3 = field3;
		}

		@Override
		public String toString() {
			return "TestModel{" +
					"field1='" + field1 + '\'' +
					", field2=" + field2 +
					", field3=" + field3 +
					'}';
		}
	}
}
