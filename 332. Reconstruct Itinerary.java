class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs("JFK");
        return result;
    }

    private void dfs(String airport) {
        PriorityQueue<String> neighborAirports = adj.get(airport);

        while (neighborAirports != null && !neighborAirports.isEmpty()) {
            String neighborAirport = neighborAirports.poll();
            dfs(neighborAirport);
        }
        result.add(0, airport);
    }
}
