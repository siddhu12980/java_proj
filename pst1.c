#include <stdio.h>
#include <string.h>

#define MAX_ITEMS 100

struct Item
{
    char name[50];
    float price;
    int quantity;
};

struct Item inventory[MAX_ITEMS];
int itemCount = 0;

void addItem()
{
    if (itemCount < MAX_ITEMS)
    {
        printf("Enter item name: ");
        scanf("%s", inventory[itemCount].name);

        printf("Enter item price: ");
        scanf("%f", &inventory[itemCount].price);

        printf("Enter item quantity: ");
        scanf("%d", &inventory[itemCount].quantity);

        printf("Item added successfully!\n");
        itemCount++;
    }
    else
    {
        printf("Inventory is full. Cannot add more items.\n");
    }
}

void updateItem()
{
    if (itemCount > 0)
    {
        printf("Enter the name of the item to update: ");
        char itemName[50];
        scanf("%s", itemName);

        int found = 0;
        int choice;
        for (int i = 0; i < itemCount; i++)
        {
            if (strcmp(inventory[i].name, itemName) == 0)
            {
                int updateQuantity;

                printf("1 for sale(subtract) : \n 2 for purchase(add) : \n");
                scanf("%d", &choice);

                printf("Enter the quantity to change from %s: ", itemName);

                scanf("%d", &updateQuantity);

                if (choice == 1)
                {

                    if (updateQuantity <= inventory[i].quantity)
                    {
                        inventory[i].quantity -= updateQuantity;
                        printf("\n %d units of %s subtracted successfully!\n", updateQuantity, itemName);
                    }
                    else
                    {
                        printf(" \n Not enough quantity in stock for %s.\n", itemName);
                    }

                    if(inventory[i].quantity==0){
                        free(*inventory.[i]);
                    }

                    found = 1;
                    break;
                }
                else
                {
                    inventory[i].quantity += updateQuantity;
                    found = 1;
                    break;
                }
            }
        }

        if (!found)
        {
            printf("Item not found in inventory.\n");
        }
    }
    else
    {
        printf("Inventory is empty. Cannot update items.\n");
    }
}

void showInventory()
{
    if (itemCount > 0)
    {
        printf("Inventory:\n");
        printf("%-20s %-10s %-10s\n", "Item Name", "Price", "Quantity");
        for (int i = 0; i < itemCount; i++)
        {
            printf("%-20s %-10.2f %-10d\n", inventory[i].name, inventory[i].price, inventory[i].quantity);
        }
    }
    else
    {
        printf("Inventory is empty.\n");
    }
}

int main()
{
    int choice;

    do
    {
        printf("\n===== Inventory Management System =====\n");
        printf("1. Add Item\n");
        printf("2. Update Item\n");
        printf("3. Show Inventory\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            addItem();
            break;
        case 2:
            showInventory();
            updateItem();
            break;
        case 3:
            showInventory();
            break;
        case 4:
            printf("Exiting program. Goodbye!\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 4);

    return 0;
}
