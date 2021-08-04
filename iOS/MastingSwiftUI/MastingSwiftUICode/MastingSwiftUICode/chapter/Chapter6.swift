//
//  Chapter6.swift
//  MastingSwiftUICode
//
//  Created by sj on 2021/8/4.
//

import SwiftUI

class Baby: ObservableObject {
    @Published var ages = [1,2,3]
    
}



struct Chapter6: View {

    @State var isPlaying : Bool = false
    @State var count : Int  = 0
    
    @State var count1 : Int  = 0
    @State var count2 : Int  = 0
    @State var count3 : Int  = 0

    @StateObject var cuteBaby = Baby()

    
    var body: some View {
        VStack {
            Button(action: {
                isPlaying.toggle()
            }){
                Image(systemName: isPlaying ? "play.circle.fill" :"stop.circle.fill")
                    .font(.system(size: 100))
                    .foregroundColor(isPlaying  ? .red : .green)
    //                .animation(.easeIn)
            }
            HStack{
                CounterButton(count: $count)
                CounterButton(count: $count)
                CounterButton(count: $count)
            }
            
            Text("\(count1 + count2 + count3)")
                .font(.system(size: 50, weight: .bold, design: .rounded))
                .foregroundColor(.red)
            
            HStack{
                CounterButton(count: $count1)
                CounterButton(count: $count2)
                CounterButton(count: $count3)
                
            }
            
            Button(action: {
//                self.cuteBaby.age += 1;
            }, label: {
                Circle()
                    .foregroundColor(.red)
                    .overlay(
                        Text("\(count)")
                            .foregroundColor(.white)
                            .font(.system(size: 30, weight: .bold, design: .monospaced))
                    )
                    .frame(width: 50, height: 50, alignment: .center)
            })
            
            
            
        }
        
    }
}

struct Chapter6_Previews: PreviewProvider {
    static var previews: some View {
        Chapter6()
    }
}


