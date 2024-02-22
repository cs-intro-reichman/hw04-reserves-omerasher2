public class ArrayOps {

    public static void main(String[] args) 
    {
        int [] a = {1, 2};
        int [] b = {0,1,3};
       // System.out.println(findMissingInt(a)); 
       // System.out.println(secondMaxValue(a)); 
       //System.out.println(containsTheSameElements(a, b));
       System.out.println(isSorted(a));
    }
    
    public static int findMissingInt (int [] array) {
        int len = array.length + 1;
        int [] comp = new int [len];
        boolean truth = false;
        int deliver =0;
        for (int i=0; i<comp.length; i++)
            comp[i] = i;
        for (int i=0; i<comp.length; i++)
        {
            for (int j=0; j<array.length; j++)
            {
                if (comp[i] == array[j])
                    truth = true;
            }
            if (truth == true)
                truth = false;
            else
            {
                deliver = comp[i];
                break;
            }
        }
        return deliver;
    }

    public static int secondMaxValue(int [] array) {
        int [] temp = new int [array.length];
        int tempMax= array[0];
        for (int i=0; i<array.length; i++)
            if (tempMax <= array[i])
                tempMax = array[i];
        for (int i=0; i<array.length; i++)
            if (tempMax != array[i])
                temp[i] = array[i];
        tempMax = temp[0];
        for (int i=0; i<temp.length; i++)
            if (tempMax <= temp[i])
                tempMax = temp[i];

        return tempMax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean truthAll = true;
        boolean[] truth = new boolean[Math.max(array1.length, array2.length)];
        int[] arrLong = (array1.length>=array2.length) ? array1 : array2 ;
        int[] arrShort = (array1.length>=array2.length) ? array2 : array1 ;
        for (int i=0; i<arrLong.length; i++) {
            for (int j : arrShort) {
                if (j==arrLong[i]) {
                    truth[i]=true;
                    break;
                } else truth[i]=false;
            }
        }
        for (boolean i : truth) {
            if (i==false) truthAll = false;
        }
        return truthAll;
    }

    public static boolean isSorted(int [] array) {
    if (array.length <= 1)
        return true;
    boolean ascending = array[0] <= array[1]; 
    for (int i = 1; i < array.length - 1; i++) 
    {
        if (ascending)
        {
            if (array[i] > array[i + 1])
                return false;
        } 
        else 
        {
            if (array[i] < array[i + 1])
                return false;
        }
    }
    return true;
    }

}
