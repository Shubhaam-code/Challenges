#include <bits/stdc++.h>
using namespace std;
bool ispossible(vector<int> &arr,int mid,int k){
    // kya karte ha?check karna ha mid ko
    int sum=0;
    for (int i=0;i<arr.size();i++){
        if(arr[i] > mid) {
            sum += arr[i] - mid;
        }
        // kya sum use ya utn agaya ya nhi agar agaya to possibe ha
        if(sum>=k){
            return true ;
        }
    }
    return false;

}

int main(){
    //input lo
    int n,k;
    cin>>n>>k;
    vector<int>nums(n);
    for(int i=0;i<n;i++){
        cin>>nums[i];
    }

    // search space
    sort(nums.begin(),nums.end());
    int start=0;
    int end=nums[n-1];
    int ans=0;

    //BS lagao

    while(start<=end){
        int mid=start+(end-start)/2;

        if(ispossible(nums,mid,k)){
            ans=mid;
            //mid possible use chota to possible hoga hi
            start=mid+1;
            
        }else{
            end=mid-1;
        }
    }
    cout <<ans;


}