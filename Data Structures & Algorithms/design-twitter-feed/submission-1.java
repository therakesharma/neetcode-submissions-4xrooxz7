class Twitter {
    int order;
    Map<Integer, List<int[]>> userTweetsMap;
    Map<Integer, Set<Integer>> userFollowingMap;

    public Twitter() {
        order = 0;
        userTweetsMap = new HashMap<>();
        userFollowingMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        order++;
        int [] tweet = new int[]{order, tweetId};
        List<int []> tweets = userTweetsMap.getOrDefault(userId, new ArrayList<>());
        tweets.add(tweet);
        userTweetsMap.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        
        Queue<int []> newsFeed = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        Set<Integer> userIds = userFollowingMap.getOrDefault(userId, new HashSet<>());
        userIds.add(userId);

        for (int user : userIds) {
            List<int []> tweets = userTweetsMap.get(user);
            if (tweets == null || tweets.size() == 0) {
                continue;
            }
            for (int i = 0; i < tweets.size(); i++) {
                int [] tweet = tweets.get(i);
                newsFeed.offer(tweet);
                if (newsFeed.size() > 10) {
                    newsFeed.poll();
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        while (!newsFeed.isEmpty()) {
            stack.add(newsFeed.poll()[1]);
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> following = userFollowingMap.getOrDefault(followerId, new HashSet<>());
        following.add(followeeId);
        userFollowingMap.put(followerId, following);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> following = userFollowingMap.get(followerId);
        if (following.isEmpty()) {
            return;
        }
        following.remove(followeeId);
        userFollowingMap.put(followerId, following);
    }

}
