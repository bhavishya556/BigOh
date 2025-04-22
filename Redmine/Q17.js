let arr =  [[1,3],[2,6],[8,10],[15,18]]

arr.sort((a,b)=>a[0]-b[0])
let ans =[];

for(let i =0; i<arr.length-1; i++){
   let curIndex = arr[i];
   let nxtIndex = arr[i+1];

   if(curIndex[1]>nxtIndex[0]){
    let element = [];
    element.push(curIndex[0])
    element.push(nxtIndex[1])
    ans.push(element);
   }else{
    ans.push(arr[i+1])
   }
}
console.log(ans);

