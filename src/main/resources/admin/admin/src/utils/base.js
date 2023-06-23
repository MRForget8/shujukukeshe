const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot9ykg1/",
            name: "springboot9ykg1",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "港口集团仓库管理系统"
        } 
    }
}
export default base
