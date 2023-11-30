
class WorkflowCheck {
    
    public static void startuptests(workflow, params, log) {
        if (params.salmon) {
            if(params.salmon_db){
                if(!FileCheck.checkoutfile("${params.salmon_db}/reflengths.bin")){
                    log.info "The salmon database is either not existing or is corrupted please check that '${params.salmon_db}' is valid, exiting now."
                    System.exit(1)
                }
            }else{
                log.info "No salmon database directory was specified, please specify a salmon database directory with '--salmon_db'. Exiting now."
                System.exit(1)
            }
        }
    }
    
}

class FileCheck {
    def static checkoutfile(def filePath) {
        def file = new File(filePath)
        //Check that file exists and is not empty.
        if (file.exists() && file.isFile() && file.size() > 0) {
            return true  
        } else {
            return false 
        }
    }
}