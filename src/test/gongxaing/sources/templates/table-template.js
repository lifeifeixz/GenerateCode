<script>
  import * as $req from '@/api/rent';
  import * as $page from '@/api/page';

  export default {
    data() {
      return {
        ...$page.pageParams,
        ...$req.checkMethod,
        tableData: null,
        isloading: false,
        allAmount: "",
        depositRechargeMgrList: [],
        rentInsuranceStatus: [],
        RefundAudit: false,
        Refunds: false,
        form: {
          userName: null,
          reason: null,
          phone: null,
          auditStatus: null,
          passWord: null
        }
      };
    },
    methods: {
      ...$page.pageMethod,
      $url$QueryList() {
        this.listLoading = true;
        $req.postRent("$url$", this.queryParams).then(data => {
          console.log(data);
          let {status, content} = data;
          if (status === "SUCCESS") {
            this.tableData = content.content;
            this.queryParams.total = parseInt(content.totalElements);
          } else if (status === "FAIL") {
            this.$message({message: content, type: 'warning'});
          }
          this.listLoading = false;
        })
      },
      initMethod() {
        this.defaultParams = {
          ...$page.defaultParams,
          id:"",
          orderId :"",
          username :"",
          plate : "",
          phone: "",
          status: "",
          total: null,
          orderTimeStart : "",
          orderTimeEnd : ""
        };
        $req.postRent("rentInsuranceStatus").then(data => {
          let {status, content} = data;
        
          if (status === "SUCCESS") {
            this.rentInsuranceStatus = content;
              console.log(this.rentInsuranceStatus)
          } else if (status === "FAIL") {
            this.$message({message: content, type: 'warning'});
          }
        });
        this.initForm();
      },
      handleFilter() {
        this.$url$QueryList();
      },
      $url$HandleSizeChange(val) {
        this.queryParams.size = val;
        this.$url$QueryList();
      },
      $url$HandleCurrentChange(val) {
        this.queryParams.page = val;
        this.$url$QueryList();
      },
    },
    created() {//初始化方法
      this.initMethod();
    }
  };
</script>