## concurrency-test  
> Visualizing transaction outcomes under different isolation levels

## Description  
> - A coffee event is held by `Starbucks`  
> - When users place an order, a rank from 1 to 100 is assigned based on the order time  
> - A maximum of 100 orders are allowed  
> - Each order reduces the coffee stock by 1  
> - The rank is assigned **only at the time of order saving**, with the goal of preventing duplication  
> - Rewards are given based on the rank of the order  
> - Reward policy:  
  > - 1st: Gold Coffee  
  > - 2nd: Silver Coffee  
  > - 3rd: Bronze Coffee  
  > - 4th–10th: Wooden Coffee  
  > - 11th–100th: Regular Coffee  
> - To simulate a high-load environment, `Thread.sleep()` and Hikari connection pool size limitation are used

## etc  
> updated in 2025.08.04
