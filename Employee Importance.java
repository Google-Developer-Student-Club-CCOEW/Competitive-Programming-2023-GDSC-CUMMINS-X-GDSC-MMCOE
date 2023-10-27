class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map= new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id,emp);
        } 
        return dfs(id,map);    
    }
    int dfs(int id,Map<Integer,Employee> map){
        int imp=0;
        for(int sub : map.get(id).subordinates){
            imp += dfs(sub,map);
        }
        return map.get(id).importance+imp;

    }
}
