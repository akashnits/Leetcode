class GFG
{
static void towerOfHanoi(int n, char src,
                    char dest, char helper)
{
    if (n == 1)
    {
        System.out.println("Move disk 1 from rod "+
                           src+" to rod "+dest);
        return;
    }
    towerOfHanoi(n - 1, src, helper, dest);
    System.out.println("Move disk "+ n + " from rod " +
                       src +" to rod " + dest ); 
    towerOfHanoi(n - 1, helper, dest, src);
}

// Driver code
public static void  main(String args[])
{
    int n = 4; // Number of disks
    towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
}
}
