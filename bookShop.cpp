
#include <iostream>

int main() {
    
    int n,max;
    int price[1000];
    int pages[10000];
    int feasible[3];
    
    std::cin>>n>>max;
    
    for(int i=0;i<n;i++){
        std::cin>>price[i];
    }
    
    for(int i=0;i<n;i++){
        std::cin>>pages[i];
    }
    
    int k;
    for(int i=0;i<n;i++){
        k=price[i];
        for(int j=i+1;j<n;j++){
            if(k+price[j]<=max){
                if(pages[i]+pages[j]>feasible[0]){
                    feasible[0]=pages[i]+pages[j];
                    feasible[1]=i;
                    feasible[2]=j;
                }
            }
        }
        
    }
    
    std::cout<<(pages[feasible[1]]+pages[feasible[2]]);

    return 0;
}