package accountManager.kotlin

import accountManager.legacy.AccountManagement
import java.lang.NumberFormatException

class Account(var accountNumber: String = "", var balance : Double = 0.0){
    fun deposit(amount: Double){
        this.balance += amount
        println("$amount 원이 입금 완료되었습니다.")
        println("현재 남은 금액은: $balance 입니다.")
    }
    fun withdraw(amount: Double){
        if(this.balance >= amount){
            this.balance -= amount
            println("현재 남은 잔액은: $balance 입니다.")
        }else {
            println("잔액이 부족합니다.")
        }
    }
    fun transferFunds(toAccount: Account, amount: Double){
        if(this.balance >= amount){
            this.balance -= amount
            toAccount.balance += amount
            println("$amount 이 ${toAccount.accountNumber}계좌로 이체되었습니다.")
        }else {
            println("잔액이 부족합니다.")
        }
    }
}

object AccountManager {
    private var maxSize = 100

//    private var accountList: Array<Account> = Array(maxSize) { Account() } 크기 설정시에
    private var accountList = mutableListOf<Account>()
    private var numAccounts : Int = 0

    fun addAccount(accountNumber: String, balance: Double){
        if(numAccounts < 100){
            var isDuplicate = false
            for (i in 0 until numAccounts) {
                if (accountList[i].accountNumber == accountNumber) {
                    isDuplicate = true
                    break // 중복 계좌를 찾으면 루프를 빠져나옵니다.
                }
            }
            if (isDuplicate) {
                println("계좌번호가 중복됩니다. 다시 설정해주십시오")
            } else {
                var ac = Account(accountNumber, balance)
                this.accountList[numAccounts] = ac
                println("$accountNumber 로 계좌가 만들어졌습니다.")
                numAccounts++
            }
        }else{
            println("더 이상 계좌를 만들 수 없습니다.")
        }
    }

    fun showAccountList(){
        if(numAccounts == 0){
            println("조회할 계좌가 없습니다.")
        }else{
            repeat(numAccounts) {
                println("계좌번호: ${accountList[it].accountNumber}, 잔액: ${accountList[it].balance}")
            }
        }
    }
    fun findAccount(accountNumber: String) : Account? {
        for(account in accountList){
            if(account.accountNumber == accountNumber){
                return account
            }else if (numAccounts == 0){
                println("계좌를 만들어주세요.")
                break
            }else {
                continue
            }
        }
        println("일치하는 계좌가 없습니다.")
        return null
    }
    fun deposit(account: Account, amount: Double){
        if(account == null){
            println("계좌번호를 다시 입력해주세요.")
        }else {
            account.deposit(amount)
        }
    }
    fun withdraw(account: Account, amount: Double){
        account.withdraw(amount)
    }

    fun transferFunds(account: Account, toAccountNumber: String, amount: Double){
        var toAccount = findAccount(toAccountNumber)
        if(toAccount != null){
            account.transferFunds(toAccount, amount)
        }else{
            println("송금받을 계좌를 다시 입력해주세요.")
        }
    }
    fun run() {
        //..
        //추가적으로 5번에 계좌이체를 해보세요.
        //보낼 계좌(from), 받는 계좌(to), 보낼 금액(amount)

        //로직: from의 balance를 amount 만큼 감소, to의 balance를 amount만큼 증가
        while (true){
            try{
            println("\n=== 계좌 관리 프로그램 ===")
            println("1. 계좌 추가")
            println("2. 계좌 목록 조회")
            println("3. 입금")
            println("4. 출금")
            println("5. 계좌이체")
            println("0. 종료")
            println("원하는 기능을 선택하세요: ")

            var choice = readln().toInt()

            if(choice == 0) {
                println("프로그램을 종료합니다.")
                break
            }
            when (choice) {
                1 -> {
                    println("계좌번호: ")
                    var accountNumber = readln()
                    println("잔액: ")
                    var balance = readln().toDouble()
                    addAccount(accountNumber, balance)
                }
                2 -> {
                    showAccountList()
                }
                3 -> {
                    println("계좌번호: ")
                    var accountNumber = readln()
                    var account = findAccount(accountNumber)
                    account?.run{
                        println("입금액: ")
                        //readlnOrNull()?.toDouble() 앞에서 try catch를 하기 때문에 또 null체크 할 필요 없다.
                        var depositAmount = readln().toDouble()
                        deposit(account, depositAmount)
                    }
                }
                4 -> {
                    println("계좌번호: ")
                    var accountNumber = readln()
                    var account = findAccount(accountNumber)
                    account?.run {
                        println("출금액: ")
                        var withdrawAmount = readln().toDouble()
                        withdraw(account, withdrawAmount)
                    }
                }
                5 -> {
                    println("계좌번호: ")
                    var accountNumber = readln()
                    var account = findAccount(accountNumber)
                    account?.run {
                        println("송금할 계좌 번호: ")
                        var sendAccountNumber = readln()
                        println("송금할 금액: ")
                        var sendAmount = readln().toDouble()
                        transferFunds(account,sendAccountNumber,sendAmount)
                    }
                }
                else -> {
                    println("번호를 제대로 입력해주세요")
                    continue
                }
            }

            }catch (e: NumberFormatException){
                println(e.message)
                println("숫자를 입력해주세요")
                continue
            }
        }
    }
}