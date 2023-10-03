def main():
    # Input: Number of customers
    n = int(input("Enter the number of customers: "))
    
    customers = []
    for _ in range(n):
        # Input: Arrival and leaving times of a customer
        a, b = map(int, input("Enter arrival and departure time separated by space: ").split())
        customers.append((a, b))
    
    events = []
    for a, b in customers:
        events.append((a, 1))  # Arrival event
        events.append((b, -1)) # Leaving event
    
    # Sort events. If times are equal, process leaving before arrival
    events.sort(key=lambda x: (x[0], x[1]))
    
    max_customers = 0
    current_customers = 0
    
    for _, event_type in events:
        current_customers += event_type
        max_customers = max(max_customers, current_customers)
    
    print(max_customers)

if __name__ == "__main__":
    main()
