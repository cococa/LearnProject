//
//  ContentView.swift
//  Clear&Clean
//
//  Created by sj on 2023/3/21.
//

import SwiftUI
import CoreData

struct ContentView: View {
    @Environment(\.managedObjectContext) private var viewContext

    @FetchRequest(
        sortDescriptors: [NSSortDescriptor(keyPath: \Item.timestamp, ascending: true)],
        animation: .default)
    private var items: FetchedResults<Item>

    var body: some View {
        NavigationView {
            List {
                ForEach(items) { item in
                    NavigationLink {

                        VStack {
                            Text("Item at \(item.timestamp!, formatter: itemFormatter)")

                        }
                        .background(Color.red)

                    } label: {
                        Text(item.timestamp!, formatter: itemFormatter)
                    }
                }
                .onDelete(perform: deleteItems)
            }
            .toolbar {
                ToolbarItem {
                    Button(action: addItem) {
                        Label("Add Item", systemImage: "plus")
                    }

                }
                ToolbarItem {
                    Button(action: test) {
                        Label("test", systemImage: "plus")
                    }
                }
            }
            Text("Select an item")
        }
        .task {
            
        }
        .frame(width: 1000, height: 620)
    }

    private func addItem() {
//        withAnimation {
//            let newItem = Item(context: viewContext)
//            newItem.timestamp = Date()
//
//            do {
//                try viewContext.save()
//            } catch {
//                // Replace this implementation with code to handle the error appropriately.
//                // fatalError() causes the application to generate a crash log and terminate. You should not use this function in a shipping application, although it may be useful during development.
//                let nsError = error as NSError
//                fatalError("Unresolved error \(nsError), \(nsError.userInfo)")
//            }
//        }
        
        getDocumentsDirectory() //NSHomeDirectory() + "/Documents"
//        print(documentsPath)
        
        
    }

    func getDocumentsDirectory() {
     

        
        
//        let fileManager = FileManager.default
//        let documents = FileManager.default.urls(for: .desktopDirectory, in: .userDomainMask)
//        print(documents)
//        if documents.isEmpty {
//            return
//        }
//        do {
//            for doc in documents{
//                let files = try fileManager.contentsOfDirectory(atPath: doc.path)
//                for file in files {
//                    let filePath = "\(doc.path)/\(file)"
//                    let fileAttributes = try fileManager.attributesOfItem(atPath: filePath)
//                    let fileSize = fileAttributes[.size] as! UInt64
//                    let fileCreationDate = fileAttributes[.creationDate] as! Date
//                    print("\(file)\nSize: \(fileSize)\nCreated: \(fileCreationDate)  \(fileAttributes[.type])  \n")
//                }
//
//
//            }
//        } catch {
//            print("Error reading directory: \(error)")
//        }
//


        
        
        
//        let savePanel = NSSavePanel()
//            savePanel.canCreateDirectories = true
//            savePanel.showsTagField = false
//            savePanel.nameFieldStringValue = "result.csv"
//            savePanel.level = NSWindow.Level(rawValue: Int(CGWindowLevelForKey(.modalPanelWindow)))
//            savePanel.begin { (result) in
//                if result.rawValue == NSApplication.ModalResponse.OK.rawValue {
//
//
//                }
//            }
        
//        let fileManager = FileManager.default
//        do {
//        let filePath = "/Users/shenjun/Library/Developer/Xcode/DerivedData"
//        let files = try fileManager.contentsOfDirectory(atPath: filePath)
//        for file in files {
////            let filePath = "\(doc.path)/\(file)"
//            let fileAttributes = try fileManager.attributesOfItem(atPath: filePath)
//            let fileSize = fileAttributes[.size] as! UInt64
//            let fileCreationDate = fileAttributes[.creationDate] as! Date
//            print("\(file)\nSize: \(fileSize)\nCreated: \(fileCreationDate)  \(fileAttributes[.type])  \n")
//        }
//        } catch {
//            print("Error reading directory: \(error)")
//        }
        
                
                print(NSHomeDirectory())
                print(NSUserName())

                let openPanel = NSOpenPanel();

                openPanel.allowsMultipleSelection = false;
                openPanel.canChooseDirectories = true;
                openPanel.canChooseFiles = true;
                openPanel.message = "本应用需要访问该目录，请点击允许按钮"
                openPanel.prompt = "允许"
                openPanel.directoryURL = URL.init(string: "/Users/shenjun");
                openPanel.begin{res in
                    print(res)
                    print(openPanel.urls)
                    print("\(NSApplication.ModalResponse.OK.rawValue)")

                            let fileManager = FileManager.default
                            do {
                            let filePath = "/Users/shenjun/Library/Developer/Xcode/DerivedData"
                            let files = try fileManager.contentsOfDirectory(atPath: filePath)
                            for file in files {
                                let fileAttributes = try fileManager.attributesOfItem(atPath: filePath)
                                let fileSize = fileAttributes[.size] as! UInt64
                                let fileCreationDate = fileAttributes[.creationDate] as! Date
                                print("\(file)\nSize: \(fileSize)\nCreated: \(fileCreationDate)  \(fileAttributes[.type])  \n")
                            }
                            } catch {
                                print("Error reading directory: \(error)")
                            }



                }
        
    }
    
    
    func test(){
//        "/Users/shenjun/Library/Developer/Xcode/DerivedData"

        let fileManager = FileManager.default
        do {
        let filePath = "/Users/shenjun/Library/Developer"
        let files = try fileManager.contentsOfDirectory(atPath: filePath)
        for file in files {
            let fileAttributes = try fileManager.attributesOfItem(atPath: filePath)
            let fileSize = fileAttributes[.size] as! UInt64
            let fileCreationDate = fileAttributes[.creationDate] as! Date
            
            print("\(file)\nSize: \(fileSize)\nCreated: \(fileCreationDate)  \(fileAttributes[.type])  \n")
        }
        
        try fileManager.removeItem(atPath: "/Users/shenjun/Library/Developer/Xcode/DerivedData/aaa")
            
            
            
        } catch {
            print("Error reading directory: \(error)")
        }
    }
    
    
    
    private func deleteItems(offsets: IndexSet) {
        withAnimation {
            offsets.map { items[$0] }.forEach(viewContext.delete)

            do {
                try viewContext.save()
            } catch {
                // Replace this implementation with code to handle the error appropriately.
                // fatalError() causes the application to generate a crash log and terminate. You should not use this function in a shipping application, although it may be useful during development.
                let nsError = error as NSError
                fatalError("Unresolved error \(nsError), \(nsError.userInfo)")
            }
        }
    }
}

private let itemFormatter: DateFormatter = {
    let formatter = DateFormatter()
    formatter.dateStyle = .short
    formatter.timeStyle = .medium
    return formatter
}()

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView().environment(\.managedObjectContext, PersistenceController.preview.container.viewContext)
    }
}
