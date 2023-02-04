package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	//@ requires data != null;
	/*@
		ensures (\forall int i;
			i >= 0 && i < data.size() - 1;
			data.get(i).compareTo(data.get(i + 1)) <= 0);
	*/
	// This is an alternative option for the postcondition above.
	/*@
		ensures (\forall int i,j;
		i >= 0 && i < data.size() && j >= 0 && j < data.size();
		i <= j ==> data.get(i).compareTo(data.get(j)) <= 0);
	*/
	public static <E extends Comparable<E>> List<E> mergeSort(List<E> data) {
		// TODO: implement, see exercise P-4.3
		if (data.size() <= 1) {
			return data;
		} else {
			List<E> fst = mergeSort(data.subList(0,data.size()/2));
			List<E> snd = mergeSort(data.subList(data.size()/2,data.size()));
			List<E> result = new ArrayList<>();
			int fi = 0;
			int si = 0;
			while (fi < fst.size()
					&& si < snd.size()) {
				if (fst.get(fi).compareTo(snd.get(si)) <= 0) {
					result.add(fst.get(fi));
					fi++;
				}else {
					result.add(snd.get(si));
					si++;
				}
			}
			if(fi<fst.size()){
				result.addAll(fst.subList(fi,fst.size()));
			} else if (si< snd.size()) {
				result.addAll(snd.subList(si,snd.size()));
			}
			return result;
		}
	}
}
