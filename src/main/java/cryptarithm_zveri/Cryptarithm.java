package cryptarithm_zveri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cryptarithm {

	static List<String> permute(char arr[]) {
		List<String> perm = new ArrayList<String>();
		int index = 0;

		if (arr.length == 1)
			perm.add("" + arr[0]);
		else {
			char arr1[] = new char[arr.length];
			char temp;

			for (int i = 0; i < arr.length; i++) {

				System.arraycopy(arr, 0, arr1, 0, arr.length);

				temp = arr1[0];
				arr1[0] = arr1[i];
				arr1[i] = temp;

				List<String> tempperm;
				tempperm = permute(Arrays.copyOfRange(arr1, 1, arr1.length));

				for (int j = 0; j < tempperm.size(); j++) {
					String s = tempperm.get(j);
					perm.add(index++, arr1[0] + s);
				}
			}
		}

		return perm;

	}

	public static void main(String[] args) {
		int z = 1;
		int v, o, l, k, i, s, a, e, r;
		String letters = "023456789";
		char arr[] = letters.toCharArray();

		List<String> dictionary = permute(arr);

		for (String loc_val : dictionary) {

			char[] array_iter = loc_val.toCharArray();
			int[] arr_iter = new int[loc_val.length()];

			for (int itArrayIndex = 0; itArrayIndex < loc_val.length(); itArrayIndex++) {
				arr_iter[itArrayIndex] = array_iter[itArrayIndex] - '0';
			}

			v = arr_iter[0];
			o = arr_iter[1];
			l = arr_iter[2];
			k = arr_iter[3];
			i = arr_iter[4];
			s = arr_iter[5];
			a = arr_iter[6];
			e = arr_iter[7];
			r = arr_iter[8];
			int volk = v * 1000 + o * 100 + l * 10 + k;
			int lisa = l * 1000 + i * 100 + s * 10 + a;
			int zveri = z * 10000 + v * 1000 + e * 100 + r * 10 + i;

			if (volk + lisa == zveri) {
				System.out.println(volk + "+" + lisa + "=" + zveri);

			}
		}
	}

}
