'''
2353. Design a Food Rating System
Solved
Medium
Topics
Companies
Hint
Design a food rating system that can do the following:

Modify the rating of a food item listed in the system.
Return the highest-rated food item for a type of cuisine in the system.
Implement the FoodRatings class:

FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
foods[i] is the name of the ith food,
cuisines[i] is the type of cuisine of the ith food, and
ratings[i] is the initial rating of the ith food.
void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
'''

class FoodRatings(object):

    def __init__(self, foods, cuisines, ratings):
        """
        :type foods: List[str]
        :type cuisines: List[str]
        :type ratings: List[int]
        """
        self.cuisine_to_heap = defaultdict(list)
        self.food_to_cuisine = {}
        self.food_to_rating = defaultdict(int)

        for i in range(len(foods)):
            self.food_to_cuisine[foods[i]] = cuisines[i]
            self.food_to_rating[foods[i]] = -ratings[i]
            heapq.heappush(self.cuisine_to_heap[cuisines[i]], (-ratings[i], foods[i]))
        

    def changeRating(self, food, newRating):
        """
        :type food: str
        :type newRating: int
        :rtype: None
        """
        self.food_to_rating[food] = -newRating
        cuisine = self.food_to_cuisine[food]
        heapq.heappush(self.cuisine_to_heap[cuisine], (-newRating, food))
        

    def highestRated(self, cuisine):
        """
        :type cuisine: str
        :rtype: str
        """
        pq = self.cuisine_to_heap[cuisine]
        while pq:
            # Get the heap peek
            topRated = pq[0]
            topRatedRating = topRated[0]
            topRatedFood = topRated[1]
            # If top rating in heap does not match food's latest rating, delete that item
            if topRatedRating != self.food_to_rating[topRatedFood]:
                heapq.heappop(pq)
                continue
            break
        return topRatedFood
            

# Your FoodRatings object will be instantiated and called as such:
# obj = FoodRatings(foods, cuisines, ratings)
# obj.changeRating(food,newRating)
# param_2 = obj.highestRated(cuisine)