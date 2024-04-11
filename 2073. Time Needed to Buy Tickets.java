class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // each second a ticket is sold

        // loop through the array, buying a ticket
        // keep track of sold tickets

        int soldTickets = 0;

        int i=0;
        int n = tickets.length;
        while(tickets[k] != 0){
            // keep selling tickets until tickets[k] becomes zero
            if(tickets[i%n] != 0){
                soldTickets++;
                tickets[i%n]--;
            }
            i++;
        }

        return soldTickets;
    }
}
