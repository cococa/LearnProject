//
//  Clear_CleanApp.swift
//  Clear&Clean
//
//  Created by sj on 2023/3/21.
//

import SwiftUI

@main
struct Clear_CleanApp: App {
    let persistenceController = PersistenceController.shared

    var body: some Scene {
        WindowGroup {
            ContentView()
                .environment(\.managedObjectContext, persistenceController.container.viewContext)
        }
    }
}
