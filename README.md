# SYSTEM_DESIGN_PARKING_LOT

# Requirements Collection for parking
   ## A. Extensible
    1. The system should be extensible to support any type of vehicle like bike, car, truck, etc.
    2. Each parking spot should support specific vehicle type.
    3. The system should support multiple pricing strategies:
        Time-based (peak hours / non-peak hours)
        Event-based (concerts / weekends, etc.)
    4. The system should support multiple payment methods – UPI, Credit Card, Cash, etc.
   
   ## B. Dynamic
      1. The system should allow dynamic configuration of floors and slots per floor. Slots must be mapped to vehicle type.
      2. The system should support multiple entry and exit gates.
      3. A ticket should be generated at the entry gate containing ID, vehicle number, and timestamp.
      4. At exit, this ticket is used to calculate the final cost.
      
   ## C. Concurrency
      1. We are building a single parking lot with no scale in the future.
      2. No two vehicles should get the same parking spot.

<img width="1919" height="813" alt="image" src="https://github.com/user-attachments/assets/11aed4a4-abaa-4773-8563-88d725897917" />

# OUTPUT
<img width="1918" height="1090" alt="image" src="https://github.com/user-attachments/assets/dc1a5a1a-c4bc-4bbe-85d6-d8d4ee9e8664" />
