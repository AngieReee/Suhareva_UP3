package com.example.suhareva_up.Domain

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object Constant {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://apcpgxvmigfjjjkiudib.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFwY3BneHZtaWdmampqa2l1ZGliIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDIyMjkzMDAsImV4cCI6MjA1NzgwNTMwMH0.vyt8RV0_2VBMtYDLvhgmMr83ysZFalPVMHNcZv3G7kM"
    ) {
        install(Postgrest)
        install(Auth)
        install(Storage)
    }
}