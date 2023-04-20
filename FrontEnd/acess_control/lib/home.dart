import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Buildings'),
      ),
      body: ListView(
        children: [
          ListTile(
            title: Text('Building 1'),
            trailing: IconButton(
              icon: Icon(Icons.delete),
              onPressed: () {
                // TODO: Delete building from database.
              },
            ),
          ),
          ListTile(
            title: Text('Building 2'),
            trailing: IconButton(
              icon: Icon(Icons.delete),
              onPressed: () {
                // TODO: Delete building from database.
              },
            ),
          ),
          SizedBox(height: 20),
          ElevatedButton(
            onPressed: () {
              // TODO: Navigate to add building screen.
            },
            child: Text('Add Building'),
          ),
        ],
      ),
    );
  }
}
