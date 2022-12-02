Interview task: Basket Service

Our team is implementing a Basket Service to calculate the cost of subscriptions that the customer wishes to buy.
Your task is to implement the BasketService interface.


Subscription prices are retrieved via the SubscriptionService interface. You are not expected to implement this, consider it a third party.
JUnit must be used to unit test BasketService against the provided Acceptance Criteria.


Third party services should be mocked.
We have the following features that we want to implement.


Please complete each feature in its own commit.
When you are finished, make sure you provide a git-bundle, so we can see your local history (see docs here).



Part 1 - Implement Basket Service:

Multiple Subscriptions exist:
- ENTERTAINMENT  £9.99
- SPORTS         £19.99
- KIDS           £6.99



Acceptance Criteria:

Scenario:

Successful basket calculation of a single subscription
Given the customer wants to purchase an ENTERTAINMENT subscription
When the basket is calculated
Then a successful response is returned with £9.99 as the charge

Scenario:

Calculation of an unknown subscription
Given the customer wants to purchase a MOVIES subscription
And the SubscriptionService does not return a price (returns null)
When the basket is calculated
Then a BasketConditionNotMetException is thrown

Scenario:

Successful basket calculation of multiple subscriptions
Given the customer wants to purchase ENTERTAINMENT and SPORTS subscriptions
When the basket is calculated
Then a successful response is returned with £29.98 as the charge




