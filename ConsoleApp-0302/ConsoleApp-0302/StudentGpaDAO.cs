﻿using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp_0302
{
    internal class StudentGpaDAO
    {
        private  SqlConnection conn = new SqlConnection();
       
        public void ExecuteNonQuery(string sql)
        {
            ConnectDB();
            using (SqlCommand command = new SqlCommand())
            {
                SqlTransaction transaction = conn.BeginTransaction(IsolationLevel.ReadCommitted);

                try
                {
                    command.CommandText = sql;
                    command.Connection = conn;
                    command.Transaction = transaction;
                    command.ExecuteNonQuery();

               
                    //トランザクションをコミットします。
                    transaction.Commit();
                }
                catch (System.Exception)
                {
                    //トランザクションをロールバックします。
                    transaction.Rollback();
                    throw;
                }
                finally
                {
                    conn.Close();
                }
            }
        }
        public void SelectFromTable(string sql)
        {
            ConnectDB();
            using (SqlCommand command = new SqlCommand())
            {
                SqlTransaction transaction = conn.BeginTransaction(IsolationLevel.ReadCommitted);

                try
                {
                    command.CommandText = sql;
                    command.Connection = conn;
                    command.Transaction = transaction;
                    using (SqlDataReader dr = command.ExecuteReader())
                    {
                        while (dr.Read())
                        {
                            Console.WriteLine(string.Format("{0}", dr["Semester"]));
                        }
                    }

                    //トランザクションをコミットします。
                    transaction.Commit();
                }
                catch (System.Exception)
                {
                    //トランザクションをロールバックします。
                    transaction.Rollback();
                    throw;
                }
                finally
                {
                    conn.Close();
                }
            }
        }
        private void ConnectDB()
        {
            using(SqlCommand command = new SqlCommand())
            {
                conn.ConnectionString =
                @"Data Source=D104-MKM30B4\SQLEXPRESS01;Initial Catalog=testDB; Integrated Security=True;";
                // トランザクションを開始します。
                conn.Open();
            }
        }
    }
}
