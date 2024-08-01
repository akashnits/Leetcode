class Solution {
    // 0-1 knapsack approach
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        Integer[][] dp = new Integer[n][shelfWidth+1];
        return findMinHeightOfArrangeMent(books, shelfWidth, books.length, 0, shelfWidth, 0, dp);
    }

    int findMinHeightOfArrangeMent(int[][] books, int shelfWidth, int n, int idx , int remainingWidth, int currMaxHeight, Integer[][] dp){
        // base condition - no more books to place
        if(idx == n){
            return currMaxHeight;
        }

        if(dp[idx][remainingWidth] != null){
            return dp[idx][remainingWidth];
        }

        int bookWidth = books[idx][0];
        int bookHeight = books[idx][1];

        // check if we have space remaining on this shelf ?
        int skip = currMaxHeight + findMinHeightOfArrangeMent(books, shelfWidth, n, idx+1, shelfWidth-bookWidth,  bookHeight, dp);
        if(remainingWidth >= bookWidth){
            // we may place it or may not
            int place = findMinHeightOfArrangeMent(books, shelfWidth, n, idx+1, remainingWidth - bookWidth, Math.max(currMaxHeight, bookHeight), dp);
            return dp[idx][remainingWidth] = Math.min(place, skip);
        }else{
            // we need to go to next shelf and place the book
            return dp[idx][remainingWidth] = skip;
        }
    }
}
