# API Design


Onderstaand wordt een standaard flow voor de Restaurant APP weergeven.
```mermaid
sequenceDiagram
    Customer->>Staff: Ask to be seated
    Staff->>+OrderSystem: Check for free table
    OrderSystem->>API: create_session
    OrderSystem->>-Staff: Return free table
    Staff->>Customer: Seat at specified table
    loop Customer orders items
        Customer->>+OrderSystem: Order dishes
        OrderSystem->>API: create_order(session_id)
        OrderSystem->>-Staff: Add order to kitchenstaff tasks
        Staff->>Customer: Deliver order
    end
    Customer->>Staff: Ask to pay
    Staff->>+OrderSystem: Find session and check orders
    OrderSystem->>API: check_session(session_id)?
    OrderSystem->>-Staff: Show orders + bill
    Staff->>Customer: Allow Customer to pay
    Customer->>OrderSystem: payment
    OrderSystem->>API: finish_session(session_id, payment_id)

```

## Voorbereidingen
Voordat deze app ten volste gebruikt kan worden, moeten de tafels en het personeel worden geregistreerd. 


* Tafels
* Tablets
* Personeel(?)
