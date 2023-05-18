#include<stdio.h>
#include<stdlib.h>
struct ll
{
    int data;
    struct ll *next;
};
typedef struct ll node;
node *start,*temp,*newnode;
void createnode(int item){
    newnode=(node*)malloc(sizeof(node));
    newnode->data=item;
    newnode->next=NULL;
}
void createlist(int x){
    createnode(x);
    if(start==NULL){
        start=newnode;
        return;
    }
    temp=start;
    while(temp->next!=NULL)
        temp=temp->next;
    temp->next=newnode;

}
void printl()
{
    temp=start;
    while (temp != NULL) {
        printf(" %d ", temp->data);
        temp = temp->next;
    }
}

int main(){
    createlist(100);
    createlist(500);
    printl();
    return 0;

}